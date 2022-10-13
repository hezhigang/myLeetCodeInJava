from objects import MaxConsecutiveOnes


def main():

    # 485. Max Consecutive Ones
    nums = [1,1,0,1,1,1]
    # nums = [1,0,1,1,0,1]
    o = MaxConsecutiveOnes.MaxConsecutiveOnes()
    i = o.findMaxConsecutiveOnes(nums)
    print( "The maximum number of consecutive 1s = {:d}".format(i) )

if __name__ == '__main__':
    main()