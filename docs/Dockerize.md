# Data Store
- Status: Progress
- Deciders: seungkwon
- Date: 2023.02.21

## Context and Problem Statement

요구사항에 Jib를 사용하여 도커 이미지 생성시 가산점이 있다고 한다.
하지만, 필수 요구사항을 먼저 구현하는데 중점을 둔다.
가산점보다 중요한것은 필수적인 요구사항이다. 필수 요구사항을 구현하지 못한채로 가산점을 획득해봐야 아무 소용이 없다.

## Decision Drivers

- 가산점!
- 2/23까지 필수요구사항 개발 완료
- Redis 적용보다 우선순위에 둔다.

## Considered Options

- [JIB](https://github.com/GoogleContainerTools/jib)

## Decision Outcome

- [JIB](https://github.com/GoogleContainerTools/jib)
    - Gradle로 docker 이미지를 관리한다는 컨셉인듯? 
