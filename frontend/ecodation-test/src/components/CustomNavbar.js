import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import { Link } from "react-router-dom";

function CustomNavbar() {
  return (
    <>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Ecodation</Navbar.Brand>
          <Nav className="me-auto gap-3">
            <Link className="text-light" to="/">
              Home
            </Link>
            <Link className="text-light" to="/create">
              Register
            </Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default CustomNavbar;
