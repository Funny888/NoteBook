package com.example.learnkotlin.model

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.view.MainActivity


class ItemAction(val recycler: RecyclerView) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.LEFT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val adap = recycler.adapter as RecyclerAdapter
        val position = viewHolder.adapterPosition
        MainActivity.getModel()
            ?.removePerson(adap.getList()[if (position != 0) position - 1 else position])
        adap.getList().removeAt(position)
        adap.notifyDataSetChanged()

    }
}