package playground.develop.socialnote.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import playground.develop.socialnote.R
import playground.develop.socialnote.adapter.LikesAdapter
import playground.develop.socialnote.database.remote.firestore.models.Like
import playground.develop.socialnote.databinding.ActivityLikesBinding
import playground.develop.socialnote.utils.Constants.Companion.USER_LIKES_INTENT_KEY
import playground.develop.socialnote.viewmodel.PostViewModel


class LikesActivity : AppCompatActivity() {
    private val mPostViewModel: PostViewModel by inject()
    private lateinit var mBinding: ActivityLikesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this@LikesActivity, R.layout.activity_likes)
        if (intent != null && intent.hasExtra(USER_LIKES_INTENT_KEY)) {
            loadUserLikes(intent.getStringExtra(USER_LIKES_INTENT_KEY))
        } else {
            finish()
        }
    }

    private fun loadUserLikes(documentName: String?) {
        mPostViewModel.loadPost(documentName).observe(this@LikesActivity, Observer { post ->
            val adapter = LikesAdapter(this@LikesActivity, post?.likes as List<Like>)
            mBinding.userLikesRecyclerView.adapter = adapter
        })
    }
}