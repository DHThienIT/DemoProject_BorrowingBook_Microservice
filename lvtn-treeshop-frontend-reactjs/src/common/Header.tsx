import React, { Fragment, useState, useEffect, useRef } from "react";
import { useNavigate } from 'react-router-dom';
import { memo } from "react";
import Search from "./Search";

const Header: React.FC = () => {
    const [currentUser, setCurrentUser] = useState('123');
    const offcanvasRef = useRef(null);

    // Hàm xử lý khi nút được bấm
    const handleButtonClick = () => {
        if (offcanvasRef.current) {
            // Sử dụng ref để thao tác với phần tử HTML
            offcanvasRef.current.classList.toggle('show-offcanvas');
        }
    };
    return (
        <Fragment>
            <header className="section-header bg-green-dark">
                <div className="section-header bg-white">
                    <section className="header-main">
                        <div className="container">
                            <div className="row gy-3 align-items-center">
                                <div className="col-lg-4 col-sm-4 col-4 d-flex justify-content-center">
                                    <img
                                        src="../assets/images/logo.jpg"
                                        alt="Avatar Logo"
                                        // onClick={() => handleFilterByCategory(1, '')}
                                        style={{ width: "15rem" }}
                                        className="rounded-pill"
                                    />
                                </div>
                                <div className="order-lg-last col-lg-4 col-sm-8 col-8">
                                    <div className="float-end">
                                        <div className="dropdown">
                                            <button
                                                data-bs-toggle="offcanvas"
                                                ref="#offcanvas_cart"
                                                className="btn btn-light button-header-size"
                                            // onClick={handleRestartCart}
                                            >
                                                <div className="btn-cart">
                                                    <i className="fa fa-shopping-cart" />
                                                    <span className="ms-1">Giỏ hàng</span>
                                                    {/* <div className="ms-1 circle">
                                                        {listCart.length}
                                                    </div> */}
                                                </div>
                                            </button>
                                            {currentUser ? (
                                                <Fragment>
                                                    <button
                                                        data-bs-toggle="offcanvas"
                                                        // ref="#offcanvas_trackingList"
                                                        className="btn btn-light"
                                                        onClick={handleButtonClick}
                                                    >
                                                        <i className="fa fa-heart"></i>
                                                        <span className="ms-1 d-none d-sm-inline-block">Theo dõi</span>
                                                    </button>

                                                    <button className="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                                        Hi.
                                                    </button>
                                                    <ul className="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                                        <li><button className="dropdown-item">Thông tin tài khoản</button></li>
                                                        <li><button className="dropdown-item" >Another action</button></li>
                                                        <li><hr className="dropdown-divider" /></li>
                                                        <li><button className="dropdown-item" >Thoát đăng nhập</button></li>
                                                    </ul>
                                                </Fragment>
                                            ) : (
                                                <Fragment>
                                                    <button
                                                        className="nav-item btn btn-light button-header-size"
                                                    // onClick={() => navigate('/login')}
                                                    >
                                                        <i className="fa-solid fa-user"></i>  <span className="ms-1 d-none d-sm-inline-block">Đăng nhập</span>
                                                    </button>
                                                    <button
                                                        className="nav-item btn btn-light button-header-size"
                                                    // onClick={() => navigate('/register')}
                                                    >
                                                        <i className="fa-solid fa-registered"></i>  <span className="ms-1 d-none d-sm-inline-block">Đăng ký</span>
                                                    </button>
                                                </Fragment>
                                            )}
                                        </div>
                                    </div>
                                </div>
                                <div className="col-lg-4 col-md-12 col-12">
                                    <Search
                                        text={'123'}
                                    // onFilterTextChange={() => { }}
                                    // onEnterSearch={() => { }}
                                    />
                                </div>
                            </div>
                        </div>
                    </section>
                    <hr />
                    {/* <div className="navbar-nav1">
                        {listCategory.map((category) => {
                            // console.log(category)
                            return (
                                <div
                                    key={category.categoryId}
                                    className="nav-link3"
                                    onClick={() => handleFilterByCategory(category.categoryId, category.detail)}
                                >
                                    {(category.categoryId !== 1) ? category.detail : 'Trang chủ'}
                                </div>
                            )
                        })}
                    </div> */}
                    {/* {openBoard && ( */}
                    <div className="navbar-nav1 bg-green-dark">
                        <div className="nav-link1">Vận chuyển nhanh chóng,<br />đáng tin cậy</div>
                        <div className="nav-link2" >Đảm bảo cây khỏe mạnh,<br />phát triển tốt</div>
                        <div className="nav-link1">Đội ngũ dịch vụ hỗ trợ<br />24/7</div>
                    </div>
                    {/* )} */}
                    <div id="offcanvas_trackingList" ref={offcanvasRef} className="offcanvas">
                        {/* Nội dung của offcanvas */}
                    </div>
                </div>
            </header>
        </Fragment>
    );
}

export default memo(Header);