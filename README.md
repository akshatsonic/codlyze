## Codlyze
This is a learning project, that covers the usage of [apache pinot](https://pinot.apache.org/) and how to carry out data aggregations based on time. Here we are using [Codeforces API](https://codeforces.com/apiHelp) as our datasource to get synced in pinot and perform time based queries on user submissions on the platform

## How to setup this project
1. Run `setup-infra.yaml` file in docker compose, this will help you expose the ports to which you can connect to apache pinot and kafka to start your ingestion
2. Explore the API endpoints to figure out how you can use your [codeforces](https://www.codeforces.com) account to sync in pinot.

## Resources to learn from
1. [Apache Pinot](https://www.youtube.com/watch?v=LMb-OK_RExE&list=PLihIrF0tCXdfN6y-twj9KtWaXM1GH4RSe) playlist by Tim Berglund
2. [Apache Kafka](https://www.youtube.com/watch?v=XFqm_ILuhs0&list=PLt1SIbA8guusxiHz9bveV-UHs_biWFegU)

## Future releases
1. Have custom queries on pinot to aggregate data and plot graphs in real time.

![Logo](http://francky.me/images/quora001.png)
