## 기술적 의사결정

### 1. 배포환경
 
 - AWS EC2 
 
### 2. CI/CD
 
 - Github Actions
 - AWS CodeDeploy

## Ground Rule

### 1. 기본 규칙

 - 개인 공부 목적의 주석은 clone 받은 레포지토리에서 따로 진행해주세요.
 - 그 외 주석은 코드에 대한 설명 등 최대한 필요한 부분에 작성하겠습니다.

### 2. Branch 전략
 - Git Flow : feature > dev > hotfix > main

### 3. Convention 

### 4. Commit 메시지 규칙
#### feat : 새로운 기능 추가, 기존 기능을 요구 사항에 맞추어 수정
ex) git commit -m "feat : 대댓글 CRUD 구현"
#### fix : 버그 수정
ex) git commit -m "fix : cors 관련 config 클래스 수정"
#### build : 빌드 관련 수정
#### chore : 패키지 매니저 수정, 그 외 기타 수정 
ex) .gitignore
#### ci : CI 관련 설정 수정
#### docs : 문서(주석) 수정
ex) git commit -m "docs : README.md 규칙 추가" 
#### style : 코드 스타일, 포맷팅에 대한 수정
#### refactor : 기능의 변화가 아닌 코드 리팩터링 ex) 변수 이름 변경
#### test : 테스트 코드 추가/수정
#### release : 버전 릴리즈
