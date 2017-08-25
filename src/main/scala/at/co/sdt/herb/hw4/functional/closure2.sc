val isOfVotingAge18 = (age: Int) => age >= 18
isOfVotingAge18(16) // false
isOfVotingAge18(20) // true

var votingAge = 18
val isOfVotingAge = (age: Int) => age >= votingAge
isOfVotingAge(16) // false
isOfVotingAge(20) // true

def printResult(f: Int => Boolean, x: Int) {
  println(f(x))
}
printResult(isOfVotingAge, 20) // true

// change votingAge in one scope
votingAge = 21
// the change to votingAge affects the result
printResult(isOfVotingAge, 20) // now false
