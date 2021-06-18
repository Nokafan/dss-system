import './register-login.js'

localStorage.token ?  axios.defaults.headers.common['Authorization'] = localStorage.token : null;

$(document).ready(function () {

    $('.register').click(function () {
        createRegister();
    })

    $('.login').click(function () {
        createLogin();
    })



    function showNextQuestion (questionList){
        //showQuestion(questionList);
        if (questionList.length === 0){
            return console.log('Empty array');
        }
    }



    axios.get('/api/property/')
        .then(response =>{

            let questionList = response.data;

            showQuestion(questionList.shift());

            $(document).on('click', '.anwser_item', function (e) {
              //showNextQuestion (questionList.shift());

                console.log( 'ansver ' + e.target.value)
                const questId = showQuestion(questionList.shift())
                console.log('quest ' + questId)

            })

        })

    function showQuestion(questionList) {
        document.getElementById('ask_wrapper').innerHTML = ` <div id="${questionList.id}"> ${questionList.title}</div>`;

        showAnswerVariant (questionList);

        let testtest = questionList.id ;
        console.log(testtest)
        return testtest  ;
    }



    function showAnswerVariant (questionID) {
        return(
            axios.get(`/api/building/property/${questionID.id}`)
                .then(test2 => {

                    createAnswerVariant (test2);

                })
        )


    }

    function createAnswerVariant (test2) {
        $('#answer_items').html(test2.data.map(name => {return answerVariant (name)}));
    }

    function answerVariant (values) {
        return(
            `
            <div class="anwser_item" data-id="${values.id}">${values.value}</div>   
            `
        )
    }



    axios.get('/api/building/')
        .then(response =>{

            $('.building_wrapper').html(response.data.map(info => {return showBuildings (info)}));
        })


    function showBuildings(info) {
        return(`
            <div class="building_item">
            <p>${info.address}</p>
            <p>${info.title}</p>
            </div>   
        `)
    }

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
