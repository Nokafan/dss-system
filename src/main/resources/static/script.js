import './register-login.js'

localStorage.token ?  axios.defaults.headers.common['Authorization'] = localStorage.token : null;

$(document).ready(function () {

    let questionList = [];
    let buldings = [];
    let history = [];
    let legend = [];

    $('.register').click(function () {
        createRegister();
    })

    $('.login').click(function () {
        createLogin();
    })

    function getQuest () {
        return(
            axios.get('/api/property/')
                .then(response => response.data)
        )
    }

    getQuest()
        .then(response => {

            questionList = response;
            const  questionId = questionList.shift()
            legend.push(questionId);
            showQuestion(questionId);

        })

    function getBuildings () {
        return (

            axios.get('/api/building/')
                .then(response => response = response.data)
        )
    }


    getBuildings ()
        .then(response => {
            buldings = response;
            createBuild(buldings);
            chooseResultInfo(buldings);
        })

    function createBuild (response) {

        $('.building_wrapper').html(response.map(info => {return showBuildings (info)}))

    }


    chooseResultInfo(buldings);

    $(document).on('click', '.anwser_item', function (e) {
        const value = e.target.textContent;

        const  test = {
            id: document.querySelector('#ask_wrapper div').id,
            title: document.querySelector('#ask_wrapper div').textContent
        }

        const questId = showQuestion(questionList.shift())


        history.push({test, value, buldings});

        /*backBtn();*/

        axios.post(`/api/building/search`, sendRequest(test, value, buldings))

            .then(response => {
                buldings = response.data;
                createBuild(buldings);
                chooseResultInfo(buldings);
            });
    })


    function chooseResultInfo(buldings) {

        if (buldings.length >= 1){
            $('.result_info').html(`<h5>Знайдено варiантiв: ${buldings.length}</h5>`)
        } else {
            $('.result_info').html(`
            <h5>Варiантiв не знайдено</h5>
            <div class="restart_search">Почати спочатку</div>
            `)
        }

    }


    $(document).on('click', '.restart_search', function (e) {

        getBuildings ()
            .then(response => {
                buldings = response;
                createBuild(buldings);
                chooseResultInfo(buldings);
            })
        getQuest()
            .then(response => {

                questionList = response;
                const  questionId = questionList.shift()
                legend.push(questionId);
                showQuestion(questionId);

            })

    })

   /* function backBtn() {
        return(
            $('.btnBack_area').html(
            `<div class="back_btn">Back</div>
            `)
        )
    }*/


   /* $(document).on('click', '.back_btn', function (e){

        const historyPop =  history.pop();
        questionList.unshift(historyPop.test)

        showQuestion(historyPop.test)

        axios.post(`/api/building/search`, sendRequest(historyPop.test, historyPop.value, historyPop.buldings))
            .then(response => {
                buldings = response.data;
                createBuild(buldings);

            });
    });*/


    function sendRequest (idQuest, answerValue, buldings) {

        let allBuild = buldings.map( element => element.id) ;

        const info = {
            questionId : idQuest.id,
            variations : [answerValue],
            buildings : allBuild
        }

        return info;
    }



    function showQuestion(questionList) {
        document.getElementById('ask_wrapper').innerHTML = ` <div id="${questionList.id}"> ${questionList.title}</div>`;

        showAnswerVariant (questionList);

        let questId = questionList ;
        return questId  ;
    }



    function showAnswerVariant (questionID) {
        return(
            axios.get(`/api/building/property/unique/${questionID.id}`)
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
            <div class="anwser_item">${values}</div>   
            `
        )
    }

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
