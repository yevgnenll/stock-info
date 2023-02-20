# Data Store 
- Status: Progress
- Deciders: seungkwon
- Date: 2023.02.21

## Context and Problem Statement

최근 5일을 저장해야 하는데 현재 날짜, 4일이 나뉘어진다.
4일의 데이터는 장이 마감되면 변경이 없지만, 현재 날짜의 경우 장을 마감하지 않았다면 high, close가 변경될 수 있다.
https://query1.finance.yahoo.com/v8/finance/chart/005930.KS?interval=1d&range=5d

간격은 1일 간격이고, 범위는 5일이다.
그런데 API의 range가 1m도 가능한걸로 봐서는 1분단위로 데이터가 갱신된다 가정할 수 있다.
그럼 매 1분마다 갱신을 해도 상관없고, 갱신이후 
## Decision Drivers

- 1분 단위 업데이트.
  - 요구사항은 삼성전자 주식으로 특정 되었기 때문에 다른 주식을 저장하는 가능성은 배제한다.
- 쓰기는 1분에 1번이라 가정할 수 있지만, 읽기는 1분에 1000번도 100,000번도 가능하다.
- 개발 속도가 빨라야 한다.

## Considered Options

- [MySQL](https://www.mysql.com/)
- [MongoDB](https://www.mongodb.com/)
- [Redis](https://redis.io/)
- [Caffeine cache](https://github.com/ben-manes/caffeine)

## Decision Outcome

- [MySQL](https://www.mysql.com/)
  - 1일전 ~ 5일전 데이터는 MySQL을 사용하여 저장한다.
  - 쓰기에 대한 가능성을 배제했기 때문에 MongoDB는 제외한다.

하단은 필수 요구사항이 완료되면 구현한다. 필수 요구사항이 수요일까지 구현되지 않으면 고려하지 않는다.

- [Redis](https://redis.io/)
  - 시간이 충분하다면 Redis는 오늘 데이터를 저장하는 저장소로 사용한다.
    - 단, 장 마감시간이 지나면 RDB로 이관되어야 한다.
- [Caffeine cache](https://github.com/ben-manes/caffeine)
  - 현재는 삼성전자 주식 만으로 특정 되었기 때문에 remote cache가 필요하지 않다고 판단한다.
  - 주어진 파라미터 기준으로 캐싱하는 caffeine을 사용한다.
  - 읽기 속도를 비약적으로 상승시킬 수 있을 것이다.
