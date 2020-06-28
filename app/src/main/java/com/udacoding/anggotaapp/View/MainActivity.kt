package com.udacoding.anggotaapp.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.udacoding.anggotaapp.Adapter.DataAdapter
import com.udacoding.anggotaapp.Dagger.ViewModels.ViewModelProviderFactory
import com.udacoding.anggotaapp.Model.getdata.DataItem
import com.udacoding.anggotaapp.Model.getdata.ResponseGetData
import com.udacoding.anggotaapp.R
import com.udacoding.anggotaapp.ViewModel.ViewModelMainActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

//TODO 9 Change AppCompatActivity menjadi DaggerAppCompatActivity
class MainActivity : DaggerAppCompatActivity() {

    //TODO 12
    @Inject
    lateinit var context: Context

    //TODO 21
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var viewModel : ViewModelMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //TODO 22
        viewModel = ViewModelProviders.of(this, providerFactory).get(ViewModelMainActivity::class.java)

        fab.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        viewModel.getListData()

        attachObserve()

        //TODO 13
        Toast.makeText(context, "Inject Context Berhasil", Toast.LENGTH_SHORT).show()


    }

    private fun attachObserve() {
        viewModel.responseData.observe(this, Observer { showData(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })

    }

    private fun showLoading(it: Boolean?) {
        if (it == true) pb.visibility = View.VISIBLE else pb.visibility = View.GONE
    }

    private fun showError(it: Throwable?) {
        Toast.makeText(applicationContext, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showData(it: ResponseGetData) {

        val adapter = DataAdapter(it.data, object : DataAdapter.OnClickListener {
            override fun detail(item: DataItem?) {

                val intent = Intent(applicationContext, InputActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)


            }

            override fun hapus(item: DataItem?) {

                AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("Hapus Data")
                    setMessage("Yakin mau hapus data ?")
                    setPositiveButton("Hapus") { dialog, which ->
                    //    hapusData(item?.id)
                        dialog.dismiss()
                    }
                    setNegativeButton("Batal") { dialog, which ->
                        dialog.dismiss()
                    }
                }.show()


            }

        })

        list.adapter = adapter

    }

}

/*private fun hapusData(id: String?) {

    val hapus = NetworkModule.service().deleteData(id ?: "")
    hapus.enqueue(object : Callback<ResponseAction> {

        override fun onResponse(
            call: Call<ResponseAction>,
            response: Response<ResponseAction>
        ) {

            Toast.makeText(applicationContext, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show()
            showData()

        }

        override fun onFailure(call: Call<ResponseAction>, t: Throwable) {

            Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()

        }

    })

}*/

/*override fun onResume() {
    super.onResume()
    showData()
}*/

