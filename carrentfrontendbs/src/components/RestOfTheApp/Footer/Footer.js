import React from "react";
import './Footer-Basic.css'

const Footer = () => {

    return (
        <div className="footer-basic">
            <footer>
                <div className="social"><a href="#"><i className="icon fab fa-instagram"></i></a><a href="#"><i
                    className="icon fab fa-snapchat"></i></a><a href="#"><i className="icon fab fa-twitter"></i></a><a
                    href="#"><i className="icon fab fa-facebook"></i></a></div>
                <ul className="list-inline">
                    <li className="list-inline-item"><a href="#">Home</a></li>
                    <li className="list-inline-item"><a href="#">Services</a></li>
                    <li className="list-inline-item"><a href="#">About</a></li>
                    <li className="list-inline-item"><a href="#">Terms</a></li>
                    <li className="list-inline-item"><a href="#">Privacy Policy</a></li>
                </ul>
                <p className="copyright">Car Rent Management System © 2017</p>
            </footer>
        </div>
    );
};

export default Footer;