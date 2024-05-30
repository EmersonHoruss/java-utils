function isTestEnv(){
  return !!process.env.ENV 
    && process.env.ENV === 'test'
}

function usingValidTestNumber(){
  return !!process.env.TEST_ENV_SMS_NUMBER 
    && process.env.TEST_ENV_SMS_NUMBER.includes('+51') 
    && process.env.TEST_ENV_SMS_NUMBER.length==7
}

function isValidTestEmail(email){
  return !!email 
    && email.includes('@lordhoruss.thebest')
}

module.exports = {
  isTestEnv,
  usingValidTestNumber,
  isValidTestEmail
};
  