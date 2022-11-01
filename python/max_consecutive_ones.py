from objects.MaxConsecutiveOnes import MaxConsecutiveOnes

def main():

    # 485. Max Consecutive Ones
    # nums = [1,1,0,1,1,1]
    nums = [1,0,1,1,0,1]
    o = MaxConsecutiveOnes()
    i = o.findMaxConsecutiveOnes(nums)
    print( "The maximum number of consecutive 1s in [{0:s}] = {1:d}".format(','.join(str(x) for x in nums), i) )

if __name__ == '__main__':
    main()