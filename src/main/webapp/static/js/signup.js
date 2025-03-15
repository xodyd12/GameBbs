//아이디 중복 확인 검사
$(document).ready(function () {
    $("#checkIdBtn").click(function () {
        let userId = $("#id").val().trim();
        let idRegex = /^[a-zA-Z0-9]{5,15}$/; // ✅ 아이디 정규식

        if (userId === "") {
            $("#idHelp").text("아이디를 입력하세요.").css("color", "red");
            return;
        }

        if(!idRegex.test(userId)){
            $("#idHelp").text("아이디는 영문자와 숫자 조합(5~15자)만 가능해요~").css("color","red");
            return;
        }

        //비밀번호 검사 및 비밀번호 확인 검사
        $(document).ready(function (){
            //비밀번호 유효성 검사
            $("#password").on("keyup", function () {
                let password = $(this).val();
                let pwRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

                if(!pwRegex.test(password)){
                    $("#pwHelp").text("비밀번호는 8자 이상, 영문 + 숫자 + 특수문자 포함이어야 합니다.").css("color", "red");
                }else{
                    $("#pwHelp").text("사용 가능한 비밀번호 입니다.").css("color","green");
                }
            });

            //비밀번호 확인 검사
            $("#confirmPassword").on("keyup", function (){
                let password = $("#password").val();
                let confirmPassword = $(this).val();

                if(password !== confirmPassword){
                    $("#confirmPwHelp").text("비밀번호가 일치하지 않습니다.").css("color", "red");
                    $("#sign_ok").prop("disabled", true);
                }else{
                    $("#confirmPwHelp").text("비밀번호가 일치합니다").css("color","green");
                    $("#confirmPassword").text("비밀번호가 일치합니다.").css("color","green");
                    $("#sign_ok").prop("disabled", false);
                }
            });
        });

        //폼 제출 시 필수 입력값 체크
        $(document).ready(function () {


            //  폼 제출 시 필수 입력값 체크
            $("#signUpForm").submit(function (event) {
                let isValid = true;

                $(".form-control").each(function () {
                    let inputVal = $(this).val().trim();
                    let inputName = $(this).attr("name");

                    // 필수 입력값 확인
                    if (inputVal === "") {
                        isValid = false;
                        $(this).css("border", "2px solid red"); // 입력란 강조
                        $("#" + inputName + "Help").text("필수 입력값입니다.").css("color", "red");
                    } else {
                        $(this).css("border", ""); // 정상 입력 시 테두리 제거
                        $("#" + inputName + "Help").text("");
                    }
                });

                // 입력값이 하나라도 없으면 폼 제출 막기
                if (!isValid) {
                    event.preventDefault(); // 기본 제출 이벤트 막기
                    alert("필수 입력란을 모두 작성해주세요.");
                }
            });
        });



        $.ajax({
            type: "GET",
            url: "/checkId",  // 절대 경로 사용
            data: { id: userId },
            success: function (response) {
                if (response === "available") {
                    $("#idHelp").text("사용 가능한 아이디입니다.").css("color", "green");
                    $("#sign_ok").prop("disabled", false);
                } else {
                    $("#idHelp").text("이미 사용 중인 아이디입니다.").css("color", "red");
                    $("#sign_ok").prop("disabled", true);
                }
            },
            error: function () {
                $("#idHelp").text("서버 오류가 발생하였습니다.").css("color", "red");
            }
        });
    });
});
