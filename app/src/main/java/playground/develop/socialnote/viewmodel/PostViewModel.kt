package playground.develop.socialnote.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import playground.develop.socialnote.database.remote.firestore.models.Comment
import playground.develop.socialnote.database.remote.firestore.models.Like
import playground.develop.socialnote.database.remote.firestore.models.Post
import playground.develop.socialnote.database.remote.firestore.models.User
import playground.develop.socialnote.repository.PostRepository

/**
 * Created by AbdullahAtta on 26-Aug-19.
 */
class PostViewModel : ViewModel(), KoinComponent {

    private val mPostRepository: PostRepository by inject()

    fun createPost(post: Post) {
        mPostRepository.createNewPost(post)
    }

    fun getPosts(): LiveData<List<Post>> {
        return mPostRepository.getPostsFeed()
    }

    fun createComment(postDocName: String, comment: Comment) {
        mPostRepository.createComment(postDocName, comment)
    }

    fun getComments(documentName: String): LiveData<List<Comment>> {
        return mPostRepository.getCommentsFeed(documentName)
    }

    fun createLikeOnPost(like: Like) {
        mPostRepository.createLikeOnPost(like)
    }

    fun removeLikePost(like: Like) { // aka Unlike
        mPostRepository.removeLike(like)
    }

    fun getUser(): LiveData<User> {
        return mPostRepository.getUser()
    }

    fun loadPost(documentName: String?): LiveData<Post> {
        return mPostRepository.loadPost(documentName)
    }

    fun getUser(userUid: String?): LiveData<User> {
        return mPostRepository.getUser(userUid)
    }

    fun getUserPosts(userUid: String?): LiveData<List<Post>> {
        return mPostRepository.getUserPosts(userUid)

    }

    fun getUserPosts(): LiveData<List<Post>> {
        return mPostRepository.getUserPosts()
    }

    fun updateUser(user: User) {
        mPostRepository.updateUser(user)
    }

    fun deleteComment(comment: Comment) {
        mPostRepository.deleteComment(comment)
    }

    fun deletePost(post: Post) {
        mPostRepository.deletePost(post)
    }

    fun getPost(documentName: String?) :LiveData<Post>{
        return mPostRepository.getPost(documentName)
    }
}