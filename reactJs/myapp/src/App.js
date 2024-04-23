import logo from './logo.svg';
import './App.css';
import Header from './Header';
import React from 'react';
import Member from './components/Member'
import Comment from './components/Comment';
import Post from './components/Post';

function App() {

  const info = {
    name: "Hoàng An",
    age: 30,
    shippingAddress: "Hà nội"
  }

  const comment = {
    title: "Tiêu đề cmt 01",
    content: "Nội dung cmt 01"
  }

  const members = [
    {
      name: "Hoàng An",
      age: 30,
      shippingAddress: "Hà nội",
      comment: {
        title: "Tiêu đề cmt 01",
        content: "Nội dung cmt 01"
      },
      posts: [
        {
          title: "Post01",
          content: "Content01"
        },
        {
          title: "Post02",
          content: "Content02"
        },
        {
          title: "Post03",
          content: "Content03"
        }
      ]
    },
    {
      name: "Nguyễn Văn A",
      age: 23,
      shippingAddress: "Hải phòng",
      comment: {
        title: "Tiêu đề cmt 02",
        content: "Nội dung cmt 02"
      },
      posts: [
        {
          title: "Post01",
          content: "Content01"
        },
        {
          title: "Post02",
          content: "Content02"
        },
        {
          title: "Post03",
          content: "Content03"
        }
      ]
    },
    {
      name: "Nguyễn Văn B",
      age: 25,
      shippingAddress: "Đà nẵng",
      comment: {
        title: "Tiêu đề cmt 03",
        content: "Nội dung cmt 03"
      },
      posts: [
        {
          title: "Post01",
          content: "Content01"
        },
        {
          title: "Post02",
          content: "Content02"
        },
        {
          title: "Post03",
          content: "Content03"
        }
      ]
    }
  ]

  const memberList = members.map((item, index)=>{
      return(
        <Member key={index} name={item.name} age={item.age} shippingAddress={item.shippingAddress}
        comment={<Comment title={item.comment.title} content={item.comment.content}/>}
        posts={item.posts}   />
      );  
  })

  return (
    
    <>
    {/* //   <Member name={info.name} age={info.age} shippingAddress={info.shippingAddress}
    //   comment={<Comment content={comment.content} title={comment.title} />} /> */}
    {memberList}
    </>
  );
}

export default App;
