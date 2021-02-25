package com.example.floatbutton.function7

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

/**
 * description:分组+头部吸附
 *
 * @author zwp
 * @since 2021/2/20
 */
class GroupItemDecoration(var groupData: ArrayList<GroupBean>) : RecyclerView.ItemDecoration() {

    val headHeight = 100
    val paint: Paint = Paint()
    val paint2 = Paint()

    init {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 2F
        paint.textSize = 50F

        paint2.color = Color.WHITE
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val view = parent.getChildAt(i)
            val index = parent.getChildAdapterPosition(view)
            for (bean in groupData) {
                /*
                注意：i与index值可能不同，parent.childCount获取的view数量不是Item的总数，而是view的总数
                 */
                if (bean.firstItemPosition == index) {
                    drawTitleView(c, view.top - 100, bean.groupTitle)
                }
            }
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        //1、确定第一个item属于哪个group
        //2、确定本页里面有没有下个group,下个group的头部在哪
        var title = ""
        var top = 0
        var currentGroup = 0
        val firstPosition =
            (parent.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        for (i in 0 until groupData.size) {
            if (firstPosition >= groupData[i].firstItemPosition) {
                title = groupData[i].groupTitle
                currentGroup = i
            }
        }
        if (currentGroup != groupData.size - 1) {
            if (groupData[currentGroup + 1].firstItemPosition <=
                (parent.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            ) {
                //页面中有下一组的数据
                val view =
                    (parent.layoutManager as LinearLayoutManager).findViewByPosition(groupData[currentGroup + 1].firstItemPosition)
                view?.let {

                    top = if (it.top - 100 > headHeight) {
                        0
                    } else {
                        //碰撞了
                        it.top - 200
                    }
                }
            }
        }

        c.drawRect(0F, top.toFloat(), parent.width.toFloat(), top + headHeight.toFloat(), paint2)
        c.drawText(title, 0F, top + 80F, paint)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildViewHolder(view).adapterPosition
        for (bean in groupData) {
            if (bean.firstItemPosition == position) {
                outRect.set(0, headHeight, 0, 0)
                return
            }
        }
        outRect.set(0, 0, 0, 0)
    }

    private fun drawTitleView(c: Canvas, top: Int, title: String) {
        c.drawText(title, 0F, top + 80F, paint)
    }
}