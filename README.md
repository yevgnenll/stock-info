# stock-info

삼성전자 주식 저장 후 반환하는 API

## 실행

### 한번에 실행하기

mysql 폴더에서 다음의 명령어를 입력합니다.

```shell
docker-compose -f start.yml up -d
```

### 개발 환경으로 실행하기

mysql 폴더에서 다음의 명령어를 입력합니다.

```shell
docker-compose up -d
```

profile은 따로 설정하지 않고(default) intelliJ를 이용해 실행합니다.

## 문서

### API 문서

1. https://satoshi.yevgnenll.me/stock-info/
2. http://localhost:8080/swagger-ui/index.html

### ADR 

1. https://github.com/yevgnenll/stock-info/tree/main/docs

## 테스트에 사용한 데이터

src/test/resources/2023Feb20.json

2023년 2월 20일 기준의 데이터를 파일로 저장하여 테스트 코드를 작성하는데 사용하였습니다.

## DB에 저장된 데이터 예시

| id | name | open | close | high | low | volume | date | created_at | updated_at|
|---|---|---|---|---|---|---|---|---|---|
|n| 삼성전자| 63600 | 63200 | 63900 | 63200 | 70606 | 2023-02-22 | 2023-02-22 HH:mm:ss | 2023-02-22 HH:mm:ss |
