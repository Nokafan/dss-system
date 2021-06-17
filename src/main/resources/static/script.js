import './register-login.js'

localStorage.token ?  axios.defaults.headers.common['Authorization'] = localStorage.token : null;

$(document).ready(function () {

$('.register').click(function () {
        createRegister();
    })

    $('.login').click(function () {
        createLogin();
    })



    function createLogin() {

        const loginList = document.createElement('div');
        loginList.className = 'loginList';
        document.body.appendChild(loginList);

        loginList.innerHTML = `
                    <div id="myModal">
                          <h5>Login</h5>
                              <div class="loginList_wrapper">
                                    <form id="loginForm">
                                        <div class="email_area">
                                            <span>Email</span>
                                             <input type="email" name="login"  class="login_mail" placeholder="Enter your mail">
                                        </div>
                                        
                                        <div class="pass_area">
                                            <span>Password</span>
                                            <input type="password" name="password" class="login_password" placeholder="Password">
                                         </div>
                                         
                                          <div class="login_form_btn-area">
                                              <button type="submit" class="login_form_btn">
                                                    Login
                                              </button>
                                          </div>
                                     </form>
                     
                              </div>
                          <span id="myModal__close" class="close">ₓ</span>
                        </div>
                        
            <div id="myOverlay"></div>
        `
        initPopUp ();
    }


    function createRegister() {

        const registerList = document.createElement('div');
        registerList.className = 'registerList';
        document.body.appendChild(registerList);

        registerList.innerHTML = `
                    <div id="myModal" class="forRegister">
                          <h5>Register</h5>
                              <div class="registerList_wrapper">
                                    <form id="registerForm" method="post">
                                    
                                        <div class="email_area-register">
                                            <span>Enter your Email for registration</span>
                                            <input name="email" type="email" data-validate="email" class="register_mail" placeholder="Enter your mail">
                                         </div>
                                         
                                        <div class="pass_area-register">
                                             <span>Enter your Password</span>
                                             <input name="password" type="password" data-validate="password" class="register_password" placeholder="Password">
                                        </div> 
                                        
                                        <div class="confirm_pass_area-register">
                                             <span>Confirm your Password</span>
                                             <input name="password2" type="password" data-validate="password2" class="register_password" placeholder="Confirm password">
                                        </div>
                                        
                                        <div class="register_form_btn-area">
                                        
                                             <button type="submit" class="rigister_form_btn">
                                                   Login
                                              </button>
                                        </div>
                                        
                                    </form>
                                    
                              </div>
                          <span id="myModal__close" class="close">ₓ</span>
                        </div>
                        
            <div id="myOverlay"></div>
        `
        initPopUp ();
    }



    function initPopUp (){

        $('body').toggleClass('no_scroll');
        $('#myOverlay').fadeIn(297, function () {
            $('#myModal')
                .css('display', 'block')
                .animate({opacity: 1}, 198);
        })
        $('#myModal__close, #myOverlay').click(function () {
            $('#myModal').animate({opacity: 0}, 198, function () {
                $(this).css('display', 'none');
                $('#myOverlay').fadeOut(297);
                $("div.loginList").remove();
                $("div.registerList").remove();
                $('body').toggleClass('no_scroll');
            })
        })
    }

});
