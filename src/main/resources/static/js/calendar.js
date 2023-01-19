const currentDate = document.querySelector(".current-date");
const daysTag = document.querySelector(".days");
const prevNextIcon = document.querySelectorAll(".icons span");

let date = new Date();
currYear = date.getFullYear();
currMonth = date.getMonth();

const months = ["January","February","March","April","May","June","July",
                "August","September","October","November","December"];
const renderCalendar = () => {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay();
    let lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate();
    let lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay();
    let lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate();
    let spanTag = "";

    for (let i = firstDayofMonth; i > 0; i--) {
        spanTag += `<span class="inactive">${lastDateofLastMonth - i + 1}</span>`;
    }
    
    for (let i = 1; i <= lastDateofMonth; i++) {
        let isToday = i === date.getDate() && currMonth === new Date().getMonth() && currYear === new Date().getFullYear() ? "active" : "";
        spanTag += `<span class="${isToday}">${i}</span>`;
    }

    for (let i = lastDayofMonth; i < 6; i++) {
        spanTag += `<span class="inactive">${i - lastDayofMonth + 1}</span>`
    }

    currentDate.innerText = `${months[currMonth]} ${currYear}`;
    daysTag.innerHTML = spanTag;
}

renderCalendar();

prevNextIcon.forEach(icon => {
    icon.addEventListener("click", ()=>{
        currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;

        if(currMonth < 0 || currMonth > 11) {
            date = new Date(currYear, currMonth);
            currYear = date.getFullYear();
            currMonth = date.getMonth();
        } else{
            date = new Date();
        }
        renderCalendar();
    });
});