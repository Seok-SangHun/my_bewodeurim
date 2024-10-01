// 나의 삼담 내역 페이지로 이동
document.getElementById('myOnetoOneBtn').addEventListener('click', (e) => {
    window.location.href = '/one-to-one/one-to-one';
});

// // 자바스크립트 코드
// document.addEventListener("DOMContentLoaded", function () {
//     const modal = document.getElementById("pop-alert2");
//     const cancelButton = document.querySelector(
//         "#pop-alert2 .btn-wrap .btn-type.v3"
//     );
//
//     // 모달 열기 함수
//     function openModal() {
//         modal.style.display = "flex"; // 모달 보이기
//         document.body.style.overflow = "hidden"; // 배경 스크롤 비활성화
//         document.querySelector(".pop-wrap").style.animation = "popUp 0.5s";
//         setTimeout(() => {
//             modalCheck = true;
//         }, 500);
//     }
//
//     // 모달 닫기 함수
//     function closeModal() {
//         document.body.style.overflow = ""; // 배경 스크롤 복원
//         document.querySelector(".pop-wrap").style.animation = "popDown 0.5s";
//         setTimeout(() => {
//             modal.style.display = "none";
//         }, 450);
//     }
//
//     // 취소 버튼 클릭 시 모달 닫기
//     if (cancelButton) {
//         cancelButton.addEventListener("click", closeModal);
//     }
//
//     // 페이지 로드 시 모달 열기
//     openModal();
// });

// 탭 활성화
const actives = document.querySelectorAll(".tab-type li");

actives.forEach((li) => {
    li.addEventListener("click", (e) => {
        if (e.target.classList.contains("choice")) {
            actives.forEach((e) => {
                e.classList.remove("active");
            });
            li.classList.add("active");
        }
    });
});

document.addEventListener("DOMContentLoaded", () => {
    // 주요 요소 선택
    const boardItems = document.querySelectorAll(".board-item"); // 게시판의 각 항목
    const moreBtn = document.getElementById("moreBtn"); // '더보기' 버튼
    const noData = document.querySelector(".nodata-box"); // 데이터가 없을 때 표시할 요소
    let visibleCount = 10; // 처음에 보여줄 항목 수

    let filteredItems = Array.from(boardItems); // 항목 배열로 변환

    // 아코디언 기능: 게시판 항목의 상세보기 토글
    document.querySelectorAll(".js_accordion").forEach((accordion) => {
        accordion.addEventListener("click", () => {
            const boardItem = accordion.closest(".board-item");
            boardItem.classList.toggle("active");
            const faqDetail = boardItem.querySelector("#faqDetail");
            faqDetail.classList.toggle("show");
        });
    });

});
