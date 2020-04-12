/*
* 다형성 - 함수와 객체의 차이 (arrayLike, arguments, documnet.queryselector 등도)
* document.queryselector('*')  의 결과는 array가 아니다 //prototpye이 NodeList
* 외부 다형성 - 객체의 메소드가 아니라, 다형성에 유리
* 내부 다형성 - 데이터형을 확인하지 않고 콜백함수에 위임.
*/

function _filter(list, predi){

    var result = [];
    for(var i =0; i<list.length; i++){
        if(predi(list[i])){
            result.push(list[i]);
        }
    }
    return result;
}


function _map(list, predi){
    var result = [];
    for(var i=0; i<list.length; i++){
        result.push(predi(list[i]));
    }
    return result;
}

function _each(list, iter){
    for(var i=0; i<list.length; i++){
        iter(list[i])
    }
}

function __map(list ,predi){
    var result = []
    _each(list, function(val){
        result.push(predi(val));
    })
    return result;
}

function __filter(list, predi){
    var result = [];
    _each(list, function(val){
        if(predi(val)) result.push(val);
    })
    return result;
}


var arr = [{id: 1, name:'1의 이름'},
            {id: 2, name:'2의 이름'},
            {id: 3, name:'3의 이름'},
            {id: 4, name:'4의 이름'}];



var changed = _filter( arr, (ele) => ele.id>2  )
var changed = _map(changed, (ele) => ele.name);
console.log(changed);
 
_map(
    _filter(arr, (ele) => ele.id>2 ),
    (ele) => ele.name   //__get('name')
)



function _curry(fn){
    return function(a){
        return arguments.length === 2? fn(a, b) : function(b){return fn(a,b);};
    }
}
function _curryr(fn){
    return function(a){
        return arguments.length === 2? fn(a, b) : function(b){return fn(b,a);};
    }
}

/**
 *  curry - 필요한 인자 개수가 채워지면 함수 본체 실행.
*/

var add = _curry(function (a,b){
    return a + b;
});
add10 = add(10);
console.log(add10(5));
console.log(add(5)(3));

var sub = _curryr(function(a,b){
    return a - b;
});

sub5 = sub(5);
console.log(sub(10,5));
console.log(sub5(10));

/** 
 *  user1.name // _get(user1, 'name')   
*/
function _get(obj, key){
    return obj===null? undefined : obj[key];
}

var __get = _curryr(function(obj, key){
    return obj === null? undefined : obj[key];
});
var user ={name:'이름은'};
var _getName = __get("name");
console.log(_getName(user));
console.log(
    __map(
        _filter(users, function(user){ return user.age > 30}),
        _get('name')
    )
);

/**
 * reduce 
 */
function _rest(list, num){
    var slice = Array.prototype.slice;
    return slice.call(list, num || 1);    //list를 this로 넘겨준다, construct 확인 시 Array로 
}

function _reduce(list, iter, memo){
    if(arguments.length==2){
        memo = list[0];
        list = _rest(list, 1);
    }
    _each(list, function(val){
        memo = iter(memo, val);
    });
 }
console.log(
     _reduce([1,2,3], add, 0)   
);     