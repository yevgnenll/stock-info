# Documentation
- Status: DONE
- Deciders: seungkwon
- Date: 2023.02.21

## Context and Problem Statement

주어진 시간이 적기 때문에 가장 빠르게 구현할 수 있는 문서가 필요하다.
문서 자동화 도구는 크게 2가지가 전달되었다.

## Decision Drivers

- 개발 편의성
- 개발 속도

## Considered Options

- API Documentation: [REST API Documentation](https://dzone.com/articles/rest-api-documentation-generators-for-java)
    - [Swagger](https://swagger.io/)
    - [Spring Rest Docs](https://spring.io/projects/spring-restdocs)

## Decision Outcome

- API Documentation:
    - REST API: [Swagger](https://swagger.io/)

회사에선 Rest docs을 사용하지만, controller test까지 만들 시간이 부족하다.
Controller에서 annotation 기반으로 문서를 정리하는 swagger가 현재로선 빠른 구현이 가능하다. 
