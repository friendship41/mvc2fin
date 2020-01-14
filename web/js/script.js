function checkJoinForm() {
    var foorm = document.join;
    if(document.getElementById("id").value===""){
        alert("아이디를 입력해 주세요");
        document.getElementById("id").focus();
        return;
    }
    if(document.getElementById("pw").value===""){
        alert("비밀번호를 입력해 주세요");
        document.getElementById("pw").focus();
        return;
    }
    if(document.getElementById("pw").value!=document.getElementById("repw").value){
        alert("비밀번호가 일치하지 않습니다");
        document.getElementById("repw").focus();
        return;
    }
    if(document.getElementById("name").value===""){
        alert("이름을 입력해 주세요");
        document.getElementById("name").focus();
        return;
    }
    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    if(!regExp.test(document.getElementById("email").value))
    {
        alert("잘못된 이메일 주소입니다.");
        document.getElementById("email").focus();
        return;
    }
    if(document.getElementById("tel2").value===""){
        alert("폰번호를 입력해 주세요");
        document.getElementById("tel2").focus();
        return;
    }
    if(document.getElementById("tel3").value===""){
        alert("폰번호를 입력해 주세요");
        document.getElementById("tel3").focus();
        return;
    }
    if(document.getElementById("postcode").value===""){
        alert("우편번호를 입력해 주세요");
        document.getElementById("postcode").focus();
        return;
    }
    if(document.getElementById("address2").value===""){
        alert("상세주소를 입력해 주세요");
        document.getElementById("address2").focus();
        return;
    }
    foorm.submit();
}

function checkmodForm() {
    var foorm = document.join;
    if(document.getElementById("id").value===""){
        alert("아이디를 입력해 주세요");
        document.getElementById("id").focus();
        return;
    }
    if(document.getElementById("pw").value!=""){
        if(document.getElementById("pw").value!=document.getElementById("repw").value){
            alert("비밀번호가 일치하지 않습니다");
            document.getElementById("repw").focus();
            return;
        }
    }
    if(document.getElementById("name").value===""){
        alert("이름을 입력해 주세요");
        document.getElementById("name").focus();
        return;
    }
    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    if(!regExp.test(document.getElementById("email").value))
    {
        alert("잘못된 이메일 주소입니다.");
        document.getElementById("email").focus();
        return;
    }
    if(document.getElementById("tel2").value===""){
        alert("폰번호를 입력해 주세요");
        document.getElementById("tel2").focus();
        return;
    }
    if(document.getElementById("tel3").value===""){
        alert("폰번호를 입력해 주세요");
        document.getElementById("tel3").focus();
        return;
    }
    if(document.getElementById("postcode").value===""){
        alert("우편번호를 입력해 주세요");
        document.getElementById("postcode").focus();
        return;
    }
    if(document.getElementById("address2").value===""){
        alert("상세주소를 입력해 주세요");
        document.getElementById("address2").focus();
        return;
    }
    foorm.submit();
}

// function checkWriteBoard() {
//     var foorm = document.gogogo;
//     if(document.getElementById("subject").value===""){
//         alert("타이틀을 입력해 주세요");
//         document.getElementById("subject").focus();
//         return;
//     }
//     if(document.getElementById("content").value===""){
//         alert("내용을 입력해 주세요");
//         document.getElementById("content").focus();
//         return;
//     }
//     foorm.submit();
// }


function goToHome() {
    location.href="/mvc2/index.do";
}

function goToJoin() {
    location.href="/mvc2/join.do";
}

function idCheck(id) {
    if(id == "")
    {
        alert("아이디를 입력해주세요");
    }
    else
    {
        url="/mvc2/idCheck.do?id="+id;
        window.open(url,"post","width=300, height=200");
    }
}



function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                // document.getElementById("sample6_extraAddress").value = extraAddr;

            } else {
                // document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("address2").focus();
        }
    }).open();
}

