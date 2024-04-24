function Post({posts}) {
    const postsJsx = posts.map((post, index) => {
        return (
            <div key={index}>
                <h3>{post.title}</h3>
                <p>{post.content}</p>
            </div>
        )
    })
    return(
        <>
            <h3>Danh sách bài viết</h3>
            {postsJsx}
        </>
    )
}

export default Post;