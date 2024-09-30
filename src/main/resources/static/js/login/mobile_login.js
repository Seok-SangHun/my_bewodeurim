document.addEventListener("DOMContentLoaded", () => {
    // 입력 필드와 레이블 위치 조정
    const inputs = document.querySelectorAll("input[type='text'], input[type='password']");

    inputs.forEach((input) => {
        const label = input.nextElementSibling;

        const updateLabelPosition = () => {
            if (input.value !== "" || document.activeElement === input) {
                label.style.top = "10px";
                label.style.left = "20px";
                label.style.fontSize = "12px";
                label.style.color = "#f0543a"; // 빨간색
            } else {
                label.style.top = "50%";
                label.style.left = "20px";
                label.style.transform = "translateY(-50%)";
                label.style.fontSize = "16px";
                label.style.color = "#999"; // 회색
            }
        };

        updateLabelPosition();

        input.addEventListener("input", updateLabelPosition);
        input.addEventListener("focus", updateLabelPosition);
        input.addEventListener("blur", updateLabelPosition);
    });

    // 비밀번호 표시 토글 기능
    const passwordField = document.getElementById("password");
    const toggleIcon = document.querySelector(".mobile-ico-eye");

    toggleIcon.addEventListener("click", () => {
        const isPassword = passwordField.type === "password";
        passwordField.type = isPassword ? "text" : "password";
        toggleIcon.classList.toggle("mobile-ico-eye-on");
    });

    // 로그인 버튼 클릭 이벤트
    document.getElementById("mobileBtnLogin").addEventListener("click", (e) => {
        e.preventDefault(); // 기본 동작 방지
        const userid = document.getElementById("userid").value;
        const password = document.getElementById("password").value;
        const modal = document.getElementById("mobile-pop-alert");
        const modalMessage = document.getElementById("mobile-pop-alert-msg");

        if (userid === "" && password === "") {
            modalMessage.textContent = "아이디와 비밀번호가 입력되지 않았습니다.";
            modal.style.display = "block";
        } else if (userid === "" && password !== "") {
            modalMessage.textContent = "아이디가 입력되지 않았습니다.";
            modal.style.display = "block";
        } else if (userid !== "" && password === "") {
            modalMessage.textContent = "비밀번호가 입력되지 않았습니다.";
            modal.style.display = "block";
        } else {
            console.log("로그인 시도");
            document['login-form'].submit(); // 로그인 시도
        }
    });

    // 모달 창 확인 버튼 클릭 이벤트
    document.getElementById("mobile-pop-alert-confirm").addEventListener("click", (e) => {
        const modal = document.getElementById("mobile-pop-alert");
        modal.style.display = "none"; // 모달 창을 닫음
        e.preventDefault(); // 기본 동작 방지
    });
});
