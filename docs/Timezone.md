# Default timezone
- Status: DONE
- Deciders: seungkwon
- Date: 2023.02.21

## Context and Problem Statement

Default timezone은 무엇으로 결정할 것인가?

## Decision Drivers

- 확장성을 고려한다.
  - 국외 주식이 추가된다는 가정을 하자
- DB가 변경될 가능성을 고려한다.

## Considered Options

- KST
- UTC-0

## Decision Outcome

- UTC-0
    - MongoDB의 경우 timezone을 다루지 않음
    - KST는 UTC+9 이다. 
    - 시간 변경은 Kotlin의 확장 함수를 사용하자

| UTC   | KST   |
|-------|-------|
| 00:00 | 09:00 |
| 03:00 | 12:00 |
| 12:00 | 21:00 |
| 15:00 | 00:00 |

