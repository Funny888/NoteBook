package com.example.learnkotlin.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.R
import com.example.learnkotlin.model.ItemAction
import com.example.learnkotlin.model.RecyclerAdapter
import kotlinx.android.synthetic.main.show_list_persons_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowPersonsFragment : Fragment() {

    lateinit var mRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_list_persons_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerForContextMenu(view)
        val model = MainActivity.getModel()
        mRecycler = view.findViewById<RecyclerView>(R.id.recycler).apply {
            setHasFixedSize(true)
            CoroutineScope(Dispatchers.Main).launch {
                adapter = RecyclerAdapter(list = model!!.fetchData())
            }
        }

        val itemAction: ItemTouchHelper.Callback = ItemAction(recycler)
        val touchHelper: ItemTouchHelper =
            ItemTouchHelper(itemAction).apply { attachToRecyclerView(recycler) }
        val lineSearch = view.findViewById<EditText>(R.id.lineSearch).apply {
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    CoroutineScope((Dispatchers.Main)).launch {
                        recycler.adapter =
                            RecyclerAdapter(
                                model!!.queryFilter(
                                    lineSearch.text.toString()
                                )
                            )
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }
            })
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        activity?.menuInflater?.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.deleteData -> {
                MainActivity.getModel()?.deleteAllData()
                (mRecycler.adapter as RecyclerAdapter).getList().clear()
                mRecycler.adapter?.notifyDataSetChanged()
            }
        }
        return true
    }
}