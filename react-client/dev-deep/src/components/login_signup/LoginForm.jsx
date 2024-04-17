import React, { useState } from "react";
import { FaUser, FaLock, FaEnvelope } from "react-icons/fa";
import "./LoginForm.css";

const LoginSigninForm = () => {
  const [login, isLogin] = useState(false);
  return (
    <div>
      {login ? (
        <LoginForm isLogin={isLogin} />
      ) : (
        <SigninForm isLogin={isLogin} />
      )}
    </div>
  );
};

const SigninForm = ({ isLogin }) => {
  return (
    <div className="wrapper">
      <form action="">
        <h1>Sign In</h1>
        <div className="input-box">
          <input type="text" placeholder="username" required />
          <FaUser className="icon" />
        </div>
        <div className="input-box">
          <input type="text" placeholder="email" required />
          <FaEnvelope className="icon" />
        </div>
        <div className="input-box">
          <input type="password" placeholder="password" required />
          <FaLock className="icon" />
        </div>
        <div className="remember-forget">
          <label>
            <input type="checkbox" />
            Remeber Me
          </label>
          <a href="#">Forgot password</a>
        </div>
        <button type="submit"> Sign In </button>
        <div className="register-link">
          <p>
            Have an account?{" "}
            <a href="#" onClick={() => isLogin(true)}>
              {" "}
              Login{" "}
            </a>
          </p>
        </div>
      </form>
    </div>
  );
};

const LoginForm = ({ isLogin }) => {
  return (
    <div className="wrapper">
      <form action="">
        <h1>Login</h1>
        <div className="input-box">
          <input type="text" placeholder="user" required />
          <FaUser className="icon" />
        </div>
        <div className="input-box">
          <input type="password" placeholder="password" required />
          <FaLock className="icon" />
        </div>
        <div className="remember-forget">
          <label>
            <input type="checkbox" />
            Remeber Me
          </label>
          <a href="#">Forgot password</a>
        </div>
        <button type="submit"> Login </button>
        <div className="register-link">
          <p>
            Don't have an account?{" "}
            <a href="#" onClick={() => isLogin(false)}>
              {" "}
              register{" "}
            </a>
          </p>
        </div>
      </form>
    </div>
  );
};

export default LoginSigninForm;
