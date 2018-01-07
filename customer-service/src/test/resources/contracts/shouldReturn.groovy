package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/v1/customer'
        body([
            "name" : "Erik"
        ])
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200

        body("""
			{
				"status": "OK"
			}
			""")
        headers {
            header(
                    'Content-Type', value(consumer('application/json'), producer(regex('application/json.*')))
            )
        }
    }
}
