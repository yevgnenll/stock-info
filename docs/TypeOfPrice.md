# Documentation
- Status: DONE
- Deciders: seungkwon
- Date: 2023.02.22

## Context and Problem Statement

확장성(국외 주식)을 위해 Double을 사용했지만 주어진 과제에서 여기까지 고민하는 것은 일을 키우는 것이다.

## Decision Drivers

Floating point를 사용해 계산하는 것은 현재 수준에선 아닌듯
삼성전자 주식은 국내 주식으로 소수점이 없다.(한화)

와 성능을 내면서 floating point 문제를 해결하는 소수점 거래는 어떻게 하는걸까??

## Considered Options

- Floating point
- Integer

## Decision Outcome

- Integer