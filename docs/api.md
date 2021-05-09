# Travel Designer API Specification

## Retrieve Travel Plan Result

```
GET /api/plan?from=<date>&to=<date>&weather=<sel>&covid19=<sel>&fortravel=<sel>&forshopping=<sel>
```

- Options can be modified according to requirements.

On success:

```
200 OK
content-type: application/json
content-length: <len>

<json>
```

- `<json>`: The computed travel plan organised in a JSON object. Example:

```json
{
  "destinations": [
    {
      "rank": 1,
      "name": "London",
      "weather": "Sunny",
      "covid19": "+2849"
    },
    {
      "rank": 2,
      "name": "Glasgow",
      "weather": "Cloudy",
      "covid19": "+439"
    }
  ]
}
```

On failure: any 4xx, 500 status code.

There may be a long poll involved; attention should be paid on the front-end.

## Jiayi's

```
/travelCity/城市名		获取这个城市信息
/travelCity		获取所有城市信息

/COVID/城市名		获取这个城市疫情信息


/weather/城市名		获取这个城市天气信息

/recommend?isWeather  是否勾选天气  Integer类型  1 代表勾选， 0代表勾选
	       isCovid      是否勾选疫情
                       isTravel     是否勾选旅游倾向
                       isShopping  是否勾选购物倾向
```
