import React from 'react';

function Header() {
    return (
        <div>
            <ul>
                <li><a className="active" href="#home">Home</a></li>
                <li style={{float:"right"}}><a href="#about">About</a></li>
                <li style={{float:"right"}}><a href="#contact">Contact</a></li>
                <li style={{float:"right"}}><a href="#news">News</a></li>

            </ul>
        </div>
    );
}

export default Header;