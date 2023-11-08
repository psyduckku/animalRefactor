window.addEventListener("DOMContentLoaded", (event)=>{
let resp=null;
async function logout(event) {
event.preventDefault();

const confirmed = confirm('로그아웃 하시겠습니까?');

const config = {
    method : 'POST',
    headers : {
    'Content-Type' : 'application/json'
    }
};

try{
    if(confirmed){
    resp = await fetch('animal/api/logout', config)
        .then((res) => res.text())
        .then((result)=>{
    if(result!=200){
        console.log(result);
    }
        location.replace('/');
        })
    }
}catch(error){
    console.error('logout error', error);
}
    }
    const logoutBtn=document.getElementById('logoutBtn');

if(logoutBtn){
    logoutBtn.addEventListener('click', logout);
}
});