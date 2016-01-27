package unique.test

import grails.persistence.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId

@Entity
@ToString(includeNames = true, includeFields = true, excludes = 'dateCreated, lastUpdated, metaClass')
@EqualsAndHashCode()
class Site implements Serializable {
    static mapWith = "mongo"

    ObjectId id
    String privateKey
    String publicKey
    String name
    String description
    String url
    boolean coins = false


    static constraints = {
        privateKey nullable: false, blank: false, maxSize: 250
        publicKey nullable: false, blank: false, maxSize: 250
        name nullable: false, blank: false, maxSize: 100
        description nullable: true, maxSize: 255
        url nullable: false, blank: false, maxSize: 250, url: true, unique: true
    }

    static mapping = {
        sort 'name': 'asc'
    }

}
