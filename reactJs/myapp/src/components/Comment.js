import React from "react";

export default class Comment extends React.Component{
    constructor(props){
        super(props);
        // this.ShowContent = () => {
        //     return <p>Demo Content</p>
        // }
        this.name = 'Pham Nam';
    }

    showContent = () => {
        console.log(this.name);
    }

    render(){
        const {title, content} = this.props;
        // const ShowContent = () => {
        //     return <p>Demo Content</p>
        // }

        return (
            <div className="comment">
                <h3>{title}</h3>
                <p>{content}</p>
                <button type="button" onClick={this.showContent}>Click</button>
            </div>
        )
    }
}

