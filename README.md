# spring-boot-demo

A simple spring boot rest api that uses memcached for caching and supports Elasticache (memcached) on AWS.

- [x] Integrate simple-spring-memcached using aws-elasticache-provider
- [x] Deploy to ElasticBeanstalk and test against elasticache cluster 
- [ ] Identify an interesting sample data set
- [ ] Integrate with MySQL and RDS
- [ ] Create public/private subnets in new VPC across AZs - 2 subnets x 3 AZ = 6 subnets
- [ ] Diagram VPC
- [ ] Use [eb-locustio-sample](https://github.com/awslabs/eb-locustio-sample) to load test
- [ ] Finish README.md

## Documentation
- http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/vpc-basic.html#vpc-basic-create
- [Using Elastic Beanstalk with Amazon VPC - Load-balancing, autoscaling environments](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/vpc.html#d0e41851)
    > To enable communication between the private subnet, and the public subnet and the 
    > Internet beyond the public subnet, create routing rules that do the following:
    >  
    >   - Route all inbound traffic to your Amazon EC2 instances through the load balancer.
    >   - Route all outbound traffic from your Amazon EC2 instances through the NAT device.
    >




## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisities

What things you need to install the software and how to install them

* memcached running on localhost:11211

```
Give examples
```

### Installing

A step by step series of examples that tell you have to get a development env running

Stay what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* Dropwizard - Bla bla bla
* Maven - Maybe
* Atom - ergaerga

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the Apache License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
* [spring-boot-samples](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples)
* [eb-locustio-sample](https://github.com/awslabs/eb-locustio-sample)