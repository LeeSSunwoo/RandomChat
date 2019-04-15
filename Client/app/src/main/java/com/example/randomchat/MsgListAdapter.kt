package com.example.randomchat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MsgListAdapter(val context: Context, val msgList: ArrayList<Msg>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.activity_msg_list_adapter, null)

        val msgItem = view.findViewById<TextView>(R.id.msgContent)

        val msg = msgList[position]

        msgItem.text = msg.msg

        return view
    }

    override fun getItem(position: Int): Any {
        return msgList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return msgList.size
    }
}