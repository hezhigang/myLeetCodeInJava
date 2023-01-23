func reformatDate(_ date: String) -> String {
    let month = ["Jan":"01", "Feb":"02", "Mar":"03",
                 "Apr":"04", "May":"05", "Jun":"06",
                 "Jul":"07", "Aug":"08", "Sep":"09",
                 "Oct":"10", "Nov":"11", "Dec":"12"]
    let dayOfMonth = ["1st":"01", "2nd":"02", "3rd":"03", "4th":"04",
                      "5th":"05", "6th":"06", "7th":"07", "8th":"08",
                      "9th":"09", "10th":"10", "11th":"11", "12th":"12",
                      "13th":"13", "14th":"14", "15th":"15", "16th":"16",
                      "17th":"17", "18th":"18", "19th":"19", "20th":"20",
                      "21st":"21", "22nd":"22", "23rd":"23", "24th":"24",
                      "25th":"25", "26th":"26", "27th":"27", "28th":"28",
                      "29th":"29", "30th":"30", "31st":"31"]
    var ymdList = date.components(separatedBy: " ")
    var yyyy : String? = ymdList[2]
    var mm : String? = month[ymdList[1]]
    var dd : String? = dayOfMonth[ymdList[0]]
    var ymd : String? = (yyyy ?? "") + "-" + (mm ?? "") + "-" + (dd ?? "")
    return ymd ?? ""
}

var ymd = reformatDate("20th Oct 2052")
print(ymd)