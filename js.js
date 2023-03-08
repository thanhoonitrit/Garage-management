function signin_close(){
      var change = document.getElementById("form_signin");
                change.style.display = "none";
            } 
    function signup_close(){
      var change = document.getElementById("form_signup");
                change.style.display = "none";
            }

    function signin_open(){
                var change = document.getElementById("form_signup");
                change.style.display = "none";
                var change = document.getElementById("form_signin");
                change.style.display = "block";
                
            }
    function validate() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var form = document.getElementsByTagName("form")[0];

    if(username=== "") {
    alert("Vui lòng nhập tên đăng nhập!");
    form.setAttribute("action","#");
    return false;
    }
    if(password === "") {
    alert("Vui lòng nhập mật khẩu!");
    form.setAttribute("action","#");
    return false;
    }
    }

    function signup_open(){
                var change = document.getElementById("form_signup");
                change.style.display = "block";
                var change2 = document.getElementById("form_signin");
                change2.style.display = "none";
                }
    function validate1() {
    var username = document.getElementById("username1").value;
    var password = document.getElementById("password1").value;
    var password1 = document.getElementById("password2").value;
    var form = document.getElementsByTagName("form")[1];

    if(username=== "") {
    alert("Vui lòng nhập tên đăng nhập!");
    form.setAttribute("action","#");
    return false;
    }
    if(password === "") {
    alert("Vui lòng nhập mật khẩu!");
    form.setAttribute("action","#");
    return false;
    }
    if(password1 === "") {
    alert("Vui lòng nhập lại mật khẩu!");
    form.setAttribute("action","#");
    return false;
    } 
    if(password1 !== password){
    alert("Mật khẩu bạn vừa nhập không khớp!");
    form.setAttribute("action","#");
    return false;
    }
    }
    
    function openeye(){
      var password = document.getElementById("password");    
      if(password.getAttribute("type") ===  "password"){
        password.setAttribute("type","text");
      } else {
        password.setAttribute("type","password");
      }
      
    }
    function openeye1(){
      var password = document.getElementById("password1");    
      if(password.getAttribute("type") ===  "password"){
        password.setAttribute("type","text");
      } else {
        password.setAttribute("type","password");
      }
      
    }
    function openeye2(){
      var password = document.getElementById("password2");     
      if(password.getAttribute("type") ===  "password"){
        password.setAttribute("type","text");
      } else {
        password.setAttribute("type","password");
      }
      
    }

    function signupnow(){
      var change = document.getElementById("form_signin");
                change.style.display = "none";
      var change2 = document.getElementById("form_signup");
                 change2.style.display = "block";
    }
    function signinnow(){
      var change = document.getElementById("form_signup");
                change.style.display = "none";
      var change2 = document.getElementById("form_signin");
      change2.style.display = "block";
    }

    
    
