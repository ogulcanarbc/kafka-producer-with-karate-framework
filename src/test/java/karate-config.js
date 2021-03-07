function fn() {
    var env = karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);

    if (!env) {
        env = 'stage';
    }

    if (env === 'local') {
        karate.log('Init Configurations Local');
        var base_url = 'http://localhost:8080';
        var kafka_broker = 'localhost:9092';

    } else if (env === 'dev') {
        karate.log('Init Configurations Dev');
        var base_url = 'dev-base-yrl:8080';
        var kafka_broker = 'dev-broker-url:9092';

    } else if (env === 'stage') {
        karate.log('Init Configurations Stage');
        var base_url = 'stage-base-url:8080';
        var kafka_broker = 'stage-broker-url:9092';

    }

    var config = {
        env: env,
        base_url: base_url,
        kafka_broker: kafka_broker,
        user_created_topic: 'user-created-topic-dummy',
    }

    return config;
}