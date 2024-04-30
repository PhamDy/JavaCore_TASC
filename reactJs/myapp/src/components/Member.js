import Avatart from "./Avatar";
import MemberInfor from "./MemberInfo";
import Comment from "./Comment";
import Post from "./Post";

const Member = props => {

    const {name, age, shippingAddress, comment, posts} = props;
  
    return(
     <div className="member-box">
        <h2>Tên: {name}</h2>
        <p>Tuổi: {age}</p>
        <p>Tuổi: {shippingAddress}</p>
            {comment}
        <Post {...props}/>
     </div>

    )
  }



export default Member;