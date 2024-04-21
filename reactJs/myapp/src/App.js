import logo from './logo.svg';
import './App.css';
import Header from './Header';
import React from 'react';

function App() {

  function getProduct(product){
    if(product.status===1){
      return (
        <>
          <p>Id: {product.id}</p>  
          <p>Name: {product.name}</p>  
          <p>Price: {product.price}</p>  
          <p>Description: {product.description}</p>  
          <p>Status: 
            {product.status==0?<span className='inactive'>Chua kich hoat
            </span>:<span className='active'>Kich hoat</span>}
          </p>  
        </>
      );
    }
  }

  const product = [
    {
      id: 1,
      name: 'san pham 1',
      price: 12000,
      description: 'desc1',
      status: 1
    },
    {
      id: 2,
      name: 'san pham 1',
      price: 12000,
      description: 'desc1',
      status: 1
    }
  ]
  console.log(getProduct(product))
  const productList = product.map((item, index)=> {
    return (
    <div key={index}>
      <p>ID: {item.id}</p>
      <p>Name: {item.name}</p>
      <p>Price: {item.price}</p>
      <hr></hr>
    </div>
    );
  });

  return (
    <>
       <h2>Danh sach san pham</h2>
       {productList}
    </>
  );
}

export default App;
