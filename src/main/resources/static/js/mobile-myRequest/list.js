let page = document.getElementById("page").value;
const more = document.getElementById("more");

const showList = () => {
    pickups.forEach((pickup) => {
    });
}

showList();

more.addEventListener("click", (e) => {
    e.preventDefault();
    if(nextPage != 0){
        page++;
        location.href = `/mobile-myRequest/mobile-myRequest-body?page=${page}`
    }else{
    //     스타일 주셈
    }
});