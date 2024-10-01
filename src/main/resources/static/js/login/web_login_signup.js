const kakaoLoginButton = document.querySelector("#kakao-login");
const loginButton = document.querySelector(".loginsignup-id-login-btn");


kakaoLoginButton.addEventListener("click",(e) => {
    console.log("카카오 로그인 들어옴");
    e.preventDefault();
    location.href='https://kauth.kakao.com/oauth/authorize?client_id=5fe128da71fd07bc0e94293df857f90d&redirect_uri=http://localhost:10000/kakao/login&response_type=code'
})

loginButton.addEventListener("click",(e) => {

    e.preventDefault();
    location.href='/login/web_login'
})