db = db.getSiblingDB('basic_authorization_app')

db.createCollection('user')

db.user.insertOne(
    {
        'username': 'Admin',
        'password': '$2a$10$/AZF.9Ma8uuH68QxxbeJteHOQguSpq0tek5YEu1TH.mmIxwr57Y4.',
        'roles': [ 'ADMIN', 'USER' ]
    })

db.user.insertOne(
    {
        'username': 'Rodrigo',
        'password': '$2a$10$/AZF.9Ma8uuH68QxxbeJteHOQguSpq0tek5YEu1TH.mmIxwr57Y4.',
        'roles': [ 'USER' ]
    })