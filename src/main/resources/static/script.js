$(document).ready(function () {



    $('.login').click(function () {
        createLogin();
    })

    $('.register').click(function () {
        createRegister();
    })

    function showNextQuestion (questionList){
        showQuestion(questionList);
        if (questionList.length === 0){
            return console.log('Empty array');
        }
    }

    function showAnswerVariant (questionID) {

        axios.get(`/api/building/property/${questionID.id}`)
            .then(test2 => {

                createAnswerVariant (test2);
                /*const answers =
                console.log(answers);
                console.log(test2);*/
            })

    }

    function createAnswerVariant (test2) {
        $('#answer_items').html(test2.data.map(name => {return answerVariant (name)}));
    }

    function answerVariant (values) {
        return(
            `
            <div data-id="${values.id}">${values.value}</div>   
            `
        )
    }

    axios.get('/api/property/')
        .then(response =>{

            let questionList = response.data;

            showQuestion(questionList.shift());

            $('.click').click(function (){
                showNextQuestion (questionList.shift());
            });


        })

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
                                    <form id="loginForm" action="" method="post">
                                        <div class="email_area">
                                            <span>Email</span>
                                             <input type="email" class="login_mail" placeholder="Enter your mail">
                                        </div>
                                        
                                        <div class="pass_area">
                                            <span>Password</span>
                                            <input type="password" class="login_password" placeholder="Password">
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
                                            <input type="email" class="register_mail" placeholder="Enter your mail">
                                         </div>
                                         
                                        <div class="pass_area-register">
                                             <span>Enter your Password</span>
                                             <input type="password" class="register_password" placeholder="Password">
                                        </div> 
                                        
                                        <div class="confirm_pass_area-register">
                                             <span>Confirm your Password</span>
                                             <input type="password" class="register_password" placeholder="Confirm password">
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

    function showQuestion(questionList) {
        document.getElementById('ask_wrapper').innerHTML = ` <div> ${questionList.title}</div>`;

        showAnswerVariant (questionList)
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
