# shopBoard v2.2.2

## ※ 개발환경
###### (aplication.yml)
IDE: IntelliJ IDEA Community   
Gradle - Groovy, Java 17   
Jar 11   
Spring Boot 2.7.6   
jvm.convert 3.3.2   
JDK 11   
mysql 8.0.35   
Lombok   
Spring Web   
Spring Data JPA   
Thymeleaf   

## ※ 게시판 주요기능
### 게시글
1. 게시글 작성(/board/save) <br>
  \- 파일(이미지) 첨부 (단일/다중)

2. 게시판 페이지(/board/, /board/paging) <br>
  \- 한 페이지 게시글 5개 <br>
  \- 최대 3개 페이지씩 <br>
  \- /board/paging?page=1 <br>
  \- /board/paging/1 <br> <p align="center">
    <img src="./image/page1.png" alt="image_01"> <br><br>
    <img src="./image/page2.png" alt="image_02"> <br><br></p>

3. 게시글 조회(/board/{id}) <br> <div class="centered-image">
    <img src="./image/detail.png" alt="image_06.png"> </div><br>

4. 게시글 수정(/board/update/{id}) <br>
  \- 상세화면에서 수정 버튼 클릭 (작성자일 경우에만 보임) <br>
  \- 서버에서 해당 게시글의 정보를 가지고 수정 화면 출력 <br> <div class="centered-image">
    <img src="./image/update.png" alt="image_06.png"> </div>

5. 게시글 수정 적용(/board/update) <br>
  \- 제목, 내용 수정 입력 받아서 서버로 요청    

6. 게시글 삭제(/board/delete/{id}) <br>
  \- 상세화면에서 삭제 버튼 클릭 (작성자일 경우에만 보임)

7. 게시글 작성 화면으로 이동(/board/create) <br> <div class="centered-image">
    <img src="./image/create.png" alt="image_06.png"> </div><br>

### 댓글
1. 댓글 작성(/comment/save)

2. 게시글에 달린 댓글들 보이기(/comment/comments) <br> <p align="center">
  <img src="./image/comment1.png" alt="image_01"> <br><br>
  <img src="./image/comment2.png" alt="image_02"> <br><br></p>

3. 댓글 삭제(/comment/delete/{id}) <br>
  \- 작성자일 경우에 보이는 댓글 옆 삭제 버튼 클릭

4. 댓글 수정(/comment/update) <br>
  \- 작성자일 경우에 보이는 댓글 옆 수정 버튼 클릭 <br>
  \- 댓글 내용 아래에 작성공간과 댓글작성 버튼이 나옴 <br>
  \- 작성공간에 새로운 내용을 적고 댓글작성 버튼을 누르면 입력한 내용으로 서버로 요청 <br>
  \- 수정 버튼을 한 번 더 누르면 작성공간과 댓글 작성버튼이 사라짐   

### 파일 다운로드
1. 게시글에 첨부한 파일(이미지) 다운(/download/{uuid}/{filename})

## ※ 향후 업데이트 예정 기능
1. 회원가입 및 로그인 기능

2. 자신이 작성한 게시글 모아보기

3. 작성자의 게시글 모아보기

4. 게시글 수정 시 이전에 첨부한 파일들도 보이기

#### v1.4.2 (2023.11.30)
1. 화면 디자인 수정
2. 게시판 페이지 번호 표시 수정 <br>
  \- 등록된 게시글 없을 시 따로 표시 <br>
  \- 첫 페이지일 경우 처음, 이전 버튼 선택 불가 <br>
  \- 마지막 페이지일 경우 다음, 마지막 버튼 선택 불가

#### v1.4.1 (2023.11.29)
1. 화면 디자인 수정
2. 게시글에 첨부한 파일 이름 표시
3. 게시글의 다운할 첨부파일 이름 표시

#### v1.4.0 (2023.11.28)
1. [추가] 게시글에 첨부한 파일(이미지) 다운(/download/{uuid}/{filename})
2. 게시글에 달린 댓글들 들어갈 때마다 항상 나오도록 수정

#### v1.3.0 (2023.11.27)
1. [수정] 게시글 작성(/board/save) <br>
  \- 파일(이미지) 첨부 (단일/다중)
2. [추가] 게시글 수정 적용(/board/update) <br>
  \- 첨부한 파일(이미지) 수정 가능

#### v1.2.0 (2023.11.24)
1. [추가] 댓글 작성(/comment/save)
2. [추가] 게시글에 달린 댓글들 보이기(/comment/comments)

#### v1.1.0 (2023.11.23)
1. [추가] 게시판 페이지 보기(/board/paging, /board/) <br>
  \- 한 페이지 5개씩 <br>
  \- 페이지 최대 3개씩
2. [추가] 게시글 작성 화면으로 이동(/board/create)
3. [추가] 게시글 조회(/board/{id}) <br>
  \- 글번호, 제목, 작성일, 내용 <br>
  \- 목록, 수정, 삭제 버튼
4. [추가] 게시글 수정(/board/update/{id})
5. [추가] 게시글 수정 적용(/board/update)
6. [추가] 게시글 삭제(/board/{id})

#### v1.0.0 (2023.11.21)
1. [추가] 게시글 작성(/board/save) <br>
  \- 제목, 내용
2. [추가] 메인 페이지 이동(/)
