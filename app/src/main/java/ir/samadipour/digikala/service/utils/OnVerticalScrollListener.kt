package ir.samadipour.digikala.service.utils

import androidx.recyclerview.widget.RecyclerView
import ir.samadipour.digikala.inteface.enum.ScrollPosition

class OnVerticalScrollListener(
    private val reachedTop: (() -> Unit)? = null,
    private val reachedBottom: (() -> Unit)? = null,
    private val scrollingUp: (() -> Unit)? = null,
    private val scrollingDown: (() -> Unit)? = null,
    private val immediate: Boolean = false
) : RecyclerView.OnScrollListener() {
    var position: ScrollPosition = ScrollPosition.IDK
    var top: Boolean = false

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (!recyclerView.canScrollVertically(-1)) { //reached top
            reachedTop?.let { it() }
            top = true
        } else if (!recyclerView.canScrollVertically(1)) { //reached bottom
            reachedBottom?.let { it() }
        } else if (dy < 0) { //up
            if (immediate)
                scrollingUp?.let { it() }
            else
                position = ScrollPosition.MIDDLE_TO_TOP

        } else if (dy > 0) { //down
            top = false
            if (immediate)
                scrollingDown?.let { it() }
            else
                position = ScrollPosition.MIDDLE_TO_BOTTOM
        }

        println(position)
    }

//    RecyclerView.SCROLL_STATE_DRAGGING //finger down
    //RecyclerView.SCROLL_STATE_IDLE //not moving anymore
    //RecyclerView.SCROLL_STATE_SETTLING //finger up
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        println(newState)

        if (!immediate && newState == RecyclerView.SCROLL_STATE_SETTLING) {
            when (position) {
                ScrollPosition.MIDDLE_TO_TOP -> if (!top) scrollingUp?.let { it() }
                ScrollPosition.MIDDLE_TO_BOTTOM -> scrollingDown?.let { it() }
                else -> return
            }
        }
    }
}