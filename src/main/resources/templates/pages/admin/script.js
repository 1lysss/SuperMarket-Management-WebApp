function toggleSidebar(){
    document.getElementById("mySidebar").classList.toggle("open");
    document.getElementById("overlay").classList.toggle("show");
}

// Active sidebar link
document.querySelectorAll(".sidebar a").forEach(link=>{
    if(link.getAttribute("href").split("/").pop()===window.location.pathname.split("/").pop()){
        document.querySelectorAll(".sidebar a").forEach(l=>l.classList.remove("active")); 
        link.classList.add("active");
    }
});

// Notifications
const notifButton = document.getElementById("notifButton");
const notifDropdown = document.getElementById("notifDropdown");
const notifList = document.getElementById("notifList");
let notifications = [{message:"Welcome!"}];
if(notifButton){
    notifButton.addEventListener("click", ()=>{
        notifDropdown.style.display = notifDropdown.style.display==="block"?"none":"block";
        notifList.innerHTML="";
        notifications.forEach(n=>{
            const li=document.createElement("li"); li.textContent=n.message; notifList.appendChild(li);
        });
    });
}